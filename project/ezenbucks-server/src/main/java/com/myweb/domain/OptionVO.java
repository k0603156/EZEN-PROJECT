package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/** 
 * ITEM_OPTION TABLE ������ ��ȯ�� ���� ��ü
 * ��ǰ ���� �ɼ� ���̺�
 * ��ǰ �ɼ�(hot,ice,all,none)
 * ������ ���� �ɼ�
 */ 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionVO {
	private int itemOptionId;
	private int itemOptionTemp;
	private int itemOptionSize;
	
	public void setOptions(int itemOptionTemp, int itempOptionSize) {
		this.itemOptionSize = itempOptionSize;
		this.itemOptionTemp = itemOptionTemp;
	}
}
