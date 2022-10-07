package br.com.exercicios.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ExerciciosM3S2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String nome = req.getParameter("nome");
        String idade = req.getParameter("idade");
        String cidade = req.getParameter("cidade");

        writer.println("<h2>Exercício 01</h2>");
        writer.println("<h4>Olá " +nome+ " você tem " +idade+ " e mora na cidade de " +cidade+ ".</h4>");

    }
}
