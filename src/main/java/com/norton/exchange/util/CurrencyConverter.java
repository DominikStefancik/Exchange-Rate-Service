package com.norton.exchange.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.norton.exchange.currency.Currency;

public class CurrencyConverter {

	private static final String CUBE_ELEMENT = "Cube";
	private static final String CURRENCY_ATTRIBUTE = "currency";
	private static final String RATE_ATTRIBUTE = "rate";
	private static final String TIME_ATTRIBUTE = "time";

	public static Map<String, List<Currency>> getCurrencyList(String xmlString) {
		Map<String, List<Currency>> currencyMap = new TreeMap<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();

			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xmlString));
			Document document = documentBuilder.parse(inputSource);

			NodeList nodeList = document.getElementsByTagName(CUBE_ELEMENT);
			Node root = nodeList.item(0);

			for (int i = 0; i < root.getChildNodes().getLength(); i++) {
				Node node = root.getChildNodes().item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element child = (Element) node;
					String time = child.getAttribute(TIME_ATTRIBUTE);
					currencyMap.put(time, new ArrayList<>());

					for (int j = 0; j < child.getChildNodes().getLength(); j++) {
						Node currencyNode = child.getChildNodes().item(j);
						if (currencyNode.getNodeType() == Node.ELEMENT_NODE) {
							Element currencyChild = (Element) currencyNode;
							String code = currencyChild.getAttribute(CURRENCY_ATTRIBUTE);
							Double rate = Double.valueOf(currencyChild.getAttribute(RATE_ATTRIBUTE));
							currencyMap.get(time).add(new Currency(code, rate));
						}
					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			ex.printStackTrace();
		}

		return currencyMap;
	}
}
