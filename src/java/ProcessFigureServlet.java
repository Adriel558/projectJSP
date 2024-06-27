import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessFigureServlet")
public class ProcessFigureServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] sides = new String[4];
        sides[0] = request.getParameter("side1");
        sides[1] = request.getParameter("side2");
        sides[2] = request.getParameter("side3");
        sides[3] = request.getParameter("side4");

        int[] values = new int[4];
        int nonEmptyCount = 0;

        for (int i = 0; i < 4; i++) {
            if (sides[i] != null && !sides[i].isEmpty()) {
                values[nonEmptyCount] = Integer.parseInt(sides[i]);
                nonEmptyCount++;
            }
        }

        String resultMessage = "";

        switch (nonEmptyCount) {
            case 1:
                int radius = values[0];
                double diameter = 2 * radius;
                double circumference = 2 * Math.PI * radius;
                double areaCircle = Math.PI * radius * radius;
                resultMessage = String.format("Figura: Círculo<br>Radio: %d<br>Diámetro: %.2f<br>Circunferencia: %.2f<br>Área: %.2f", 
                                               radius, diameter, circumference, areaCircle);
                break;
            case 3:
                int a = values[0], b = values[1], c = values[2];
                String tipoTriangulo;
                if (a == b && b == c) {
                    tipoTriangulo = "Equilátero";
                } else if (a == b || b == c || a == c) {
                    tipoTriangulo = "Isósceles";
                } else {
                    tipoTriangulo = "Escaleno";
                }
                double s = (a + b + c) / 2.0;
                double areaTriangle = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                resultMessage = String.format("Figura: Triángulo %s<br>Lados: %d, %d, %d<br>Área: %.2f", 
                                               tipoTriangulo, a, b, c, areaTriangle);
                break;
            case 4:
                if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3]) {
                    int side = values[0];
                    int perimeterSquare = 4 * side;
                    int areaSquare = side * side;
                    resultMessage = String.format("Figura: Cuadrado<br>Lado: %d<br>Perímetro: %d<br>Área: %d", 
                                                   side, perimeterSquare, areaSquare);
                } else {
                    int l1 = values[0], l2 = values[1], l3 = values[2], l4 = values[3];
                    if (l1 == l3 && l2 == l4) {
                        int perimeterRectangle = 2 * (l1 + l2);
                        int areaRectangle = l1 * l2;
                        resultMessage = String.format("Figura: Rectángulo<br>Lados: %d, %d<br>Perímetro: %d<br>Área: %d", 
                                                       l1, l2, perimeterRectangle, areaRectangle);
                    } else {
                        resultMessage = "Los valores no corresponden a un rectángulo válido.";
                    }
                }
                break;
            default:
                resultMessage = "Ingrese entre 1 a 4 valores.";
                break;
        }

        request.setAttribute("resultMessage", resultMessage);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
