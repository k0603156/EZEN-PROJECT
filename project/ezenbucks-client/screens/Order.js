import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";

import Button from "../components/atoms/Button";
import Col from "../components/atoms/Col";
import Container from "../components/atoms/Container";
import Greeting from "../components/molcules/Greeting";
import Text from "../components/atoms/Text";

export default function Order({ navigation, route }) {
  return (
    <Container style={{ padding: 0, flex: 1, backgroundColor: Colors.bgColor }}>
      <Greeting message="주문 결제 화면입니다." />
      <Text title="주문 매장" size="sm" />
      <Col>
        <Text title="한국프레스센터점" size="xl" />
        <Text title="서울 특별시 중구 세종대로 124(태평로1가)" size="md" />
      </Col>
      <Text title="주문 옵션" size="sm" />
      <Col>
        <Text title="포장 옵션" size="md" />
        <Text
          title="전체 포장(음료는 캐리어에, 푸드와 상품은 종이백에 포장)"
          size="sm"
        />
      </Col>
      <Text title="결제" size="sm" />
      <Col>
        <Text title="결제수단" size="md" />
      </Col>
      <Text title="최종 결제할 메뉴" size="sm" />
      <Col>
        <Text title="초콜릿 블랙 콜드 브루" size="md" />
      </Col>
      <Text title="최종 결제 금액" size="xl" />
      <Text title="11,200원" size="lg" textAlign="right" />
      <Button
        title="주문하기"
        style={{ backgroundColor: Colors.darkGreen }}
        textStyle={{ color: "white" }}
      />
    </Container>
  );
}
