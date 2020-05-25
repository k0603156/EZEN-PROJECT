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
	private int item_id;
	private String item_name;
	private int item_price;
	private String item_species;
	private String item_temp;
}