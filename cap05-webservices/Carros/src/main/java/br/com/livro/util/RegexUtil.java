package br.com.livro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;

public class RegexUtil {

	private static final Pattern regexAll = Pattern.compile("/carros");
	private static final Pattern regexById = Pattern.compile("/carros/([0-9]*)");

	// Verifica se a URL é no padrão "/carros/id"
	public static Long matchId(String requestUri) throws ServletException {
		// Verifica o ID
		Matcher matcher = regexById.matcher(requestUri);

		if (matcher.find() && matcher.groupCount() > 0) {
			String s = matcher.group(1);

			if (s != null && s.trim().length() > 0) {
				Long id = Long.parseLong(s);
				return id;
			}
		}

		return null;
	}

	// Verifica se a URL é no padrão "carros/id"
	public boolean matchAll(String requetUri) throws ServletException {
		Matcher matcher = regexAll.matcher(requetUri);

		if (matcher.find()) return true;

		return false;
	}

}
