import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";
import { SafeAreaView, ScrollView } from "react-native";
import Button from "../components/atoms/Button";
import Row from "../components/atoms/Row";
import Col from "../components/atoms/Col";
import Container from "../components/atoms/Container";
import Greeting from "../components/molcules/Greeting";
import Text from "../components/atoms/Text";

const lableStyle = {
  marginTop: 10,
};
export default function Cart({ navigation, route }) {
  return (
    <Container style={{ padding: 0, flex: 1, backgroundColor: Colors.bgColor }}>
      <Greeting message="cart" />
      <SafeAreaView>
        <ScrollView>
          <Col>
            <Text title="주문 매장" size="sm" />
            <Col>
              <Text title="한국프레스센터점" size="xl" />
              <Text
                title="서울 특별시 중구 세종대로 124(태평로1가)"
                size="sm"
              />
            </Col>
            <Text title="주문 옵션" size="sm" style={lableStyle} />
            <Col>
              <Text title="포장 옵션" size="md" />
              <Text
                title="전체 포장(음료는 캐리어에, 푸드와 상품은 종이백에 포장)"
                size="sm"
              />
            </Col>
            <Text title="결제" size="sm" style={lableStyle} />
            <Col>
              <Text title="결제수단" size="md" />
            </Col>
            <Text title="최종 결제할 메뉴" size="sm" style={lableStyle} />

            <Row>
              <Col>
                <Text title="초콜릿 블랙 콜드 브루" size="md" />
                <Text title="Chocolate Black Cold Brew" size="sm" />
              </Col>
              <Col style={{ flex: 1, justifyContent: "center" }}>
                <Text
                  title="5,600원"
                  size="sm"
                  style={{ textAlign: "right" }}
                />
              </Col>
            </Row>
            <Row>
              <Col>
                <Text title="초콜릿 블랙 콜드 브루" size="md" />
                <Text title="Chocolate Black Cold Brew" size="sm" />
              </Col>
              <Col style={{ flex: 1, justifyContent: "center" }}>
                <Text
                  title="5,600원"
                  size="sm"
                  style={{ textAlign: "right" }}
                />
              </Col>
            </Row>
            <Text title="최종 결제 금액" size="xl" style={lableStyle} />
            <Col>
              <Text title="11,200원" size="lg" textAlign="right" />
            </Col>
            <Button
              title="주문하기"
              style={{ backgroundColor: Colors.darkGreen, borderRadius: 6 }}
              textStyle={{ color: "white" }}
            />
          </Col>
        </ScrollView>
      </SafeAreaView>
    </Container>
  );
}
