/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Arbalo AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.opentdc.texts;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.opentdc.service.LocalizedTextModel;
import org.opentdc.util.LanguageCode;

/**
 * @author Bruno Kaiser
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SingleLangText {
	private String textId;
	private String localizedTextId;
	private String text;
	private LanguageCode languageCode;

	/**
	 * Empty constructor.
	 */
	public SingleLangText() {
	}
	
	public SingleLangText(String textId, LocalizedTextModel ltm) {
		this.textId = textId;
		this.localizedTextId = ltm.getId();
		this.text = ltm.getText();
		this.languageCode = ltm.getLanguageCode();
	}
	
	/**
	 * @return the id of the TextModel object
	 */
	public String getTextId() {
		return textId;
	}

	/**
	 * @param tagId the id of the TextModel object
	 */
	public void setTextId(String tagId) {
		this.textId = tagId;
	}

	/**
	 * @return the id of the LocalizedText object
	 */
	public String getLocalizedTextId() {
		return localizedTextId;
	}

	/**
	 * @param localizedTextId the id of the LocalizedText object
	 */
	public void setLocalizedTextId(String localizedTextId) {
		this.localizedTextId = localizedTextId;
	}

	/**
	 * @return the language code
	 */
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param lang the language code
	 */
	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}
	
	/**
	 * @return the text of the tag (one word)
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text of the tag (one word)
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/******************************* Comparator *****************************/
	/**
	 * Comparator for comparing two TagTextModel based on the tag text.
	 */
	public static Comparator<SingleLangText> TextComparator = new Comparator<SingleLangText>() {

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * @return -1 if the first object is null of smaller; otherwise it returns +1
		 */
		public int compare(SingleLangText obj1, SingleLangText obj2) {
			if (obj1.getText() == null) {
				return -1;
			}
			if (obj2.getText() == null) {
				return 1;
			}

			String _attr1 = obj1.getText();
			String _attr2 = obj2.getText();

			// ascending order
			return _attr1.compareTo(_attr2);

			// descending order
			// return _attr2.compareTo(_attr1);
		}
	};
}
