package br.com.exercicios.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class M3S2E2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        writer.println("<h3>Exercício 02</h3>");
        writer.println("<h4>Olá, informe o login e a senha:</h4>");

        if (login.equals("admin") && senha.equals("password")) {
            writer.println("Bem vindo, usuário admin");
        }else {
            writer.println("Login e/ou senha inválidos");
        }

    }
}
