//package szamologepszervlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/szamologep.do")
public class Szamologepservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultDTO resultDTO = new ResultDTO(); // objektum ami tárolja majd az infókat
		List<String> errorList = new ArrayList<String>();

		String aString = req.getParameter("a");
		Double a = 0.0;
		if (aString == null) {
			errorList.add("Az a parameter nem lehet ures");
		} else {
			try {
				a = Double.parseDouble(aString);
			} catch (NumberFormatException ex) {
				errorList.add("Az a parameternek szamnak kell lennie");
			}
		}
		resultDTO.setA(aString);

		String bString = req.getParameter("b");
		Double b = 0.0;
		if (bString == null) {
			errorList.add("A b parameter nem lehet ures");
		} else {
			try {
				b = Double.parseDouble(aString);
			} catch (NumberFormatException ex) {
				errorList.add("A b parameternek szamnak kell lennie");
			}
		}
		resultDTO.setB(bString);

		String operator = req.getParameter("operator");
		resultDTO.setOperator(operator);

		if (operator == null) {
			errorList.add("Az operator nem lehet ures");
		}

		Double result = 0.0;
		resultDTO.setResult(result);
		resultDTO.setErrorList(errorList);
		if (errorList.isEmpty()) {
			if ("+".equals(operator)) {
				result = a + b;
			} else {
				errorList.add("Nem tamogatott muvelet");
			}
		}

		// eltarolja a kéréd attribútumba az összes infót
		req.setAttribute("result", resultDTO);

		// forward
		RequestDispatcher rd = req.getSession().getServletContext().getRequestDispatcher("/");

		rd.forward(req, resp);
	}

}
