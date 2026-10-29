<%@ page import="org.gerdoc.service.UsuarioService" %>
<%@ page import="org.gerdoc.service.impl.UsuarioServiceImpl" %>
<%@ page import="org.gerdoc.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Proyecto funcionando</h1>
    <%
        String usuarioId = request.getParameter( "id" );

        UsuarioService usuarioService = null;
        Long id = null;
        Usuario usuario = null;
        if( usuarioId != null )
        {
            id = Long.parseLong( usuarioId );
            usuarioService = new UsuarioServiceImpl( );
            usuario = usuarioService.findById( id );
        }
    %>
    <table class="table">
        <thead>
        <tr class="table-dark" align="center">
            <th scope="col" colspan="2" >Información</th>
        </tr>
        </thead>
        <%
        if( usuario != null )
        {
        %>
            <tbody>
                <tr>
                    <td>Nombre</td>
                    <td><%= usuario.getNombre( )%></td>
                </tr>
                <tr>
                    <td>Edad</td>
                    <td><%= usuario.getCreditos( )%></td>
                </tr>
            </tbody>
        <%
        }
        %>
    </table>
    <a href="Usuarios.jsp" class="btn btn-secondary">
        Regresar
    </a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>