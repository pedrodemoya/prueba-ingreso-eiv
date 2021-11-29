package com.eiv.pruebaingreso.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eiv.pruebaingreso.entities.Localidad;
import com.eiv.pruebaingreso.entities.PersonaPK;
import com.eiv.pruebaingreso.entities.Usuario;
import com.eiv.pruebaingreso.enums.Genero;
import com.eiv.pruebaingreso.repositories.LocalidadRepository;
import com.eiv.pruebaingreso.repositories.PersonaRepository;
import com.eiv.pruebaingreso.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Usuario getUserByLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return usuarioRepository.findByUsuario(auth.getName());
	}

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsuario(nombreUsuario);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		UserDetails userDetails = new User(usuario.getUsuario(), usuario.getPassword(), authorities);

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.setAttribute("usuario", usuario);
		return userDetails;
	}

	@Transactional
	public Usuario crear(Integer tipoDocumento, Integer numeroDocumento, String nombreApellido,
			LocalDate fechaNacimiento, String genero, Boolean esArgentino, String correoElectronico, byte[] foto,
			Integer idLocalidad, String codigoPostal, String nombreUsuario, String password) throws Exception {
		try {
			PersonaPK personaPK = new PersonaPK(tipoDocumento, numeroDocumento);
			
			Usuario usuario = new Usuario();
			
			usuario.setPersonaPK(personaPK);
			usuario.setNombre(nombreApellido);
			usuario.setFechNacimiento(fechaNacimiento);
			usuario.setGenero(Genero.valueOf(genero));
			usuario.setEsArgentino(esArgentino);
			usuario.setCorreoElectronico(correoElectronico);
			usuario.setFotoCara(foto);

			Localidad localidad = localidadRepository.findById(idLocalidad).get();
			usuario.setLocalidad(localidad);

			if (codigoPostal == null) {
				usuario.setCodigoPostal(localidad.getCodigoPostal());
			} else {
				usuario.setCodigoPostal(codigoPostal);
			}		
			
			usuario.setUsuario(nombreUsuario);
			usuario.setPassword(encoder.encode(password));

			personaRepository.save(usuario);
			return usuario;
		} catch (Exception e) {
			throw new Exception("Error al crearUsuario");
		}
	}

	@Transactional
	public Usuario modificar(Usuario usuario1, String nombreUsuario, String password) throws Exception {
		try {
			Usuario usuario = usuarioRepository.findByUsuario(usuario1.getUsuario());
			usuario.setUsuario(nombreUsuario);
			usuario.setPassword(encoder.encode(password));

			usuarioRepository.save(usuario);
			return usuario;
		} catch (Exception e) {
			throw new Exception("Error al modificar Usuario");
		}
	}

	@Transactional
	public void eliminar(Usuario usuario) throws Exception {
		try {
			usuarioRepository.delete(usuario);
		} catch (Exception e) {
			throw new Exception("Error al eliminar usuario");
		}
	}

	@Transactional(readOnly = true)
	public List<Usuario> listarTodos() throws Exception {
		try {
			List<Usuario> usuarios = usuarioRepository.findAll();

			return usuarios;
		} catch (Exception e) {
			throw new Exception("Error al listar usuarios");
		}
	}
}
