/*
 * Copyright 2021-2022 The original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.vaadin.addons.yuri0x7c1.bslayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 *
 * @author yuri0x7c1
 *
 */
@Tag("bs-column")
@JsModule("./bs-layout/bs-column.js")
public class BsColumn extends Component implements HasComponents, HasStyle {

	public enum Size {
		XS(new String[]{"xs", "xs-1", "xs-2", "xs-3", "xs-4", "xs-5", "xs-6", "xs-7", "xs-8", "xs-9", "xs-10", "xs-11", "xs-12", "xs-auto"}),
		SM(new String[]{"sm", "sm-1", "sm-2", "sm-3", "sm-4", "sm-5", "sm-6", "sm-7", "sm-8", "sm-9", "sm-10", "sm-11", "sm-12", "sm-auto"}),
		MD(new String[]{"md", "md-1", "md-2", "md-3", "md-4", "md-5", "md-6", "md-7", "md-8", "md-9", "md-10", "md-11", "md-12", "md-auto"}),
		LG(new String[]{"lg", "lg-1", "lg-2", "lg-3", "lg-4", "lg-5", "lg-6", "lg-7", "lg-8", "lg-9", "lg-10", "lg-11", "lg-12", "lg-auto"}),
		XL(new String[]{"xl", "xl-1", "xl-2", "xl-3", "xl-4", "xl-5", "xl-6", "xl-7", "xl-8", "xl-9", "xl-10", "xl-11", "xl-12", "xl-auto"});

		public static int NO_SIZE_ATRR_NAME_INDEX = 0;
		public static int AUTO_SIZE_ATTR_NAME_INDEX = 13;

		private final String[] attrNames;

		Size(String[] attrNames) {
			this.attrNames = attrNames;
		}

		public String[] getAttrNames() {
			return attrNames;
		}

		public static void validateSizeValue(int sizeValue) {
			if (sizeValue < 1 || sizeValue > 12) {
				throw new RuntimeException("Size value must be in range [1-12]!");
			}
		}
	}

	public enum Offset {
		XS(new String[]{"offset-xs-1", "offset-xs-2", "offset-xs-3", "offset-xs-4", "offset-xs-5", "offset-xs-6", "offset-xs-7","offset-xs-8",
				"offset-xs-9", "offset-xs-10", "offset-xs-11"}),
		SM(new String[]{"offset-sm-1", "offset-sm-2", "offset-sm-3", "offset-sm-4", "offset-sm-5", "offset-sm-6", "offset-sm-7", "offset-sm-8",
				"offset-sm-9", "offset-sm-10", "offset-sm-11"}),
		MD(new String[]{"offset-md-1", "offset-md-2", "offset-md-3", "offset-md-4", "offset-md-5", "offset-md-6", "offset-md-7", "offset-md-8",
				"offset-md-9", "offset-md-10", "offset-md-11"}),
		LG(new String[]{"offset-lg-1", "offset-lg-2", "offset-lg-3", "offset-lg-4", "offset-lg-5", "offset-lg-6", "offset-lg-7", "offset-lg-8",
				"offset-lg-9", "offset-lg-10", "offset-lg-11"}),
		XL(new String[]{"offset-xl-1", "offset-xl-2", "offset-xl-3", "offset-xl-4", "offset-xl-5", "offset-xl-6", "offset-xl-7", "offset-xl-8",
				"offset-xl-9", "offset-xl-10", "offset-xl-11"});

		private final String[] attrNames;

		Offset(String[] attrNames) {
			this.attrNames = attrNames;
		}

		public String[] getAttrNames() {
			return attrNames;
		}
	}

	public BsColumn() {}

	public BsColumn(Component... components) {
		add(components);
	}

	public void addSize(Size size) {
		for (String attrName : size.getAttrNames()) {
			getElement().removeAttribute(attrName);
		}

		getElement().setAttribute(size.getAttrNames()[Size.NO_SIZE_ATRR_NAME_INDEX], "");
	}

	public void addSize(Size size, int sizeValue) {
		Size.validateSizeValue(sizeValue);

		for (String attrName : size.getAttrNames()) {
			getElement().removeAttribute(attrName);
		}

		getElement().setAttribute(size.getAttrNames()[sizeValue], "");
	}

	public void addSizeAuto(Size size) {
		for (String attrName : size.getAttrNames()) {
			getElement().removeAttribute(attrName);
		}

		getElement().setAttribute(size.getAttrNames()[Size.AUTO_SIZE_ATTR_NAME_INDEX], "");
	}

	public void setSizes(int xs, int sm, int md, int lg, int xl) {
		addSize(Size.XS, xs);
		addSize(Size.SM, sm);
		addSize(Size.MD, md);
		addSize(Size.LG, lg);
		addSize(Size.XL, xl);
	}

	public void addOffset(Offset offset, int offsetValue) {
		if (offsetValue < 1 || offsetValue > 11) {
			throw new RuntimeException("Offset value must be in range [1-11]!");
		}

		for (String attrName : offset.getAttrNames()) {
			getElement().removeAttribute(attrName);
		}

		getElement().setAttribute(offset.getAttrNames()[offsetValue-1], "");
	}

	public void setOffsets(int xs, int sm, int md, int lg, int xl) {
		addOffset(Offset.XS, xs);
		addOffset(Offset.SM, sm);
		addOffset(Offset.MD, md);
		addOffset(Offset.LG, lg);
		addOffset(Offset.XL, xl);
	}

	public BsColumn withSize(Size size) {
		addSize(size);
		return this;
	}

	public BsColumn withSize(Size size, int sizeValue) {
		addSize(size, sizeValue);
		return this;
	}

	public BsColumn withSizeAuto(Size size) {
		addSizeAuto(size);
		return this;
	}

	public BsColumn withSizes(int xs, int sm, int md, int lg, int xl) {
		setSizes(xs, sm, md, lg, xl);
		return this;
	}

	public BsColumn withOffset(Offset offset, int offsetValue) {
		addOffset(offset, offsetValue);
		return this;
	}

	public BsColumn withOffsets(int xs, int sm, int md, int lg, int xl) {
		setOffsets(xs, sm, md, lg, xl);
		return this;
	}
}