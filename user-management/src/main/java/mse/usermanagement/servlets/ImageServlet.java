package mse.usermanagement.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		new File(getImagesDir()).mkdirs();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("id");
		String typeBlog = req.getParameter("type");
		if (username == null || username.isEmpty()) {
			resp.sendError(400, "Id parameter is not provided ");
			return;
		}

		String fileName = getImagesDir() + username;

		File file = new File(fileName);

		if (!file.exists()) {
			if (!typeBlog.isEmpty() & typeBlog != null & typeBlog.equals("user")) {
				file = new File(getImagesDir() + "defaultImg.png");
			} else if (!typeBlog.isEmpty() & typeBlog != null & typeBlog.equals("blog")) {
				file = new File(getImagesDir() + "defaultBlogImg.png");
			}

		}

		byte[] bytes = Files.readAllBytes(Paths.get(file.toURI()));
		resp.addHeader("Content-type", "image");
		resp.addHeader("Content-type", Integer.toString(bytes.length));

		resp.getOutputStream().write(bytes);
	}

	public static String getImagesDir() {
		return System.getProperty("user.home") + "/user-management/";
	}
}
