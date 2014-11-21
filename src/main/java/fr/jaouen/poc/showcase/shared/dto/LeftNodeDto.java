package fr.jaouen.poc.showcase.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LeftNodeDto implements IsSerializable {

	private String label;
	private String icon;
	private boolean isLeaf;

	public LeftNodeDto() {
	}

	public LeftNodeDto(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}
