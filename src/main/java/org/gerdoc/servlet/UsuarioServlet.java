package org.gerdoc.servlet;

import org.gerdoc.model.Usuario;
import org.gerdoc.service.UsuarioService;
import org.gerdoc.service.impl.UsuarioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet
{
    @Serial
    private static final long serialVersionUID = 1L;
    private final UsuarioService usuarioService = new UsuarioServiceImpl( );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String accion = req.getParameter("accion");
        if ("delete".equals(accion))
        {
            Long id = Long.parseLong(req.getParameter("id"));
            usuarioService.deleteById(id);
            resp.sendRedirect("Usuarios.jsp");
            return;
        }
        String username = req.getParameter("username" );
        String pasword =  req.getParameter("pasword" );
        int rol_id = Integer.parseInt( req.getParameter("rol_id" ) );
        int alumno_id = Integer.parseInt(req.getParameter("alumno_id"));
        int profesor_id = Integer.parseInt(req.getParameter("profesor_id"));
        Long id = Long.parseLong( req.getParameter("id" ) );

        Usuario usuario = Usuario.builder( )
                .username( username )
                .pasword( pasword )
                .rol_id( rol_id )
                .alumno_id( alumno_id )
                .profesor_id( profesor_id )
                .build();
        if( "update".equals(accion) )
        {
            usuario.setId( id );
            usuarioService.update( usuario );
        }
        else
        {
            usuarioService.save( usuario );
        }
        resp.sendRedirect("Usuarios.jsp");
    }
}
