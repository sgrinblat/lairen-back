package lairentcg.lairen.controllers;

import lairentcg.lairen.config.JWTUtil;
import lairentcg.lairen.entidades.AuthenticationRequest;
import lairentcg.lairen.entidades.AuthenticationResponse;
import lairentcg.lairen.entidades.Usuario;
import lairentcg.lairen.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody AuthenticationRequest jwtRequest) throws Exception {
        try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void autenticar(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }


//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
//
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//            UserDetails userDetails = userCreationService.loadUserByUsername(request.getUsername());
//            String jwt = jwtUtil.generateToken(userDetails);
//            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
//        } catch (BadCredentialsException e) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }
//
//    @GetMapping("/actual-usuario")
//    public Usuario obtenerUsuarioActual(Principal principal) {
//        return (Usuario) userCreationService.loadUserByUsername(principal.getName());
//    }

}
