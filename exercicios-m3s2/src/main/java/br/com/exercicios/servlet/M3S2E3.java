package br.com.exercicios.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Cadastro Aluno", urlPatterns = "/cadastro.do")
public class M3S2E3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>Aluno cadastrado!</h1>");

        String nomeAluno = req.getParameter("nomeAluno");
        String nomeDisciplina = req.getParameter("nomeDisciplina");
        double nota1 = Double.parseDouble(req.getParameter("nota1"));
        double nota2 = Double.parseDouble(req.getParameter("nota2"));
        double nota3 = Double.parseDouble(req.getParameter("nota3"));
        double nota4 = Double.parseDouble(req.getParameter("nota4"));
        double media = (nota1+nota2+nota3+nota4)/4;

        writer.println("<ul>");
        writer.println("<li>Olá "+nomeAluno+"</li>");
        writer.println("<li>Suas notas são: "+nota1+" "+nota2+" "+nota3+" "+nota4+"</li>");
        writer.println("<li>e sua média na disciplina "+nomeDisciplina+" é: "+media+"</li>");
        writer.println("</ul>");
    }
}
