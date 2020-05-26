package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/** 
 * Item table ������ ��ȯ�� ���� ��ü
 * ��ǰ ���̺�
 * ��ǰ �̸�
 * ��ǰ ����
 * ��ǰ ����(coffee, food)
 * ��ǰ �ɼ�(hot,ice,all,none)
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVO {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemSpecies;
	private String itemTemp;
}