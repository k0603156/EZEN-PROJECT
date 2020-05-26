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
  marginTop: 14,
};
export default function Order({
  navigation,
  route: {
    params: {
      items,
      shop: { distance, shopAddress, shopName },
    },
  },
}) {
  return (
    <Container style={{ padding: 0, flex: 1, backgroundColor: Colors.bgColor }}>
      <Greeting message="주문 결제 화면입니다." />
      <SafeAreaView>
        <ScrollView>
          <Col>
            <Text title={shopName} size="sm" />
            <Col>
              <Text title="한국프레스센터점" size="xl" />
              <Text title={shopAddress} size="sm" />
            </Col>
            <Text title="주문 옵션" size="sm" style={lableStyle} />
            <Col>
              <Text title="포장 옵션" size="md" />
              <Text
                title="전체 포장(음료는 캐리어에, 푸드와 상품은 종이백에 포장)"
                size="xs"
              />
            </Col>
            <Text title="결제" size="sm" style={lableStyle} />
            <Col>
              <Text title="결제수단" size="md" />
            </Col>
            <Text title="최종 결제할 메뉴" size="sm" style={lableStyle} />
            {items.map(({ itemId, itemName, itemPrice }) => (
              <Row key={itemId}>
                <Col>
                  <Text title={itemName} size="md" />
                  <Text title="Chocolate Black Cold Brew" size="sm" />
                </Col>
                <Col style={{ flex: 1, justifyContent: "center" }}>
                  <Text
                    title={`${itemPrice}원`}
                    size="sm"
                    style={{ textAlign: "right" }}
                  />
                </Col>
              </Row>
            ))}

            <Text title="최종 결제 금액" size="xl" style={lableStyle} />
            <Col>
              <Text
                title={`${items.reduce(
                  (acc, { itemPrice }) => acc + itemPrice,
                  0,
                )}원`}
                size="lg"
                textAlign="right"
              />
            </Col>
            <Col>
              <Button
                title="주문하기"
                style={{ backgroundColor: Colors.darkGreen, borderRadius: 6 }}
                textStyle={{ color: "white" }}
              />
            </Col>
          </Col>
        </ScrollView>
      </SafeAreaView>
    </Container>
  );
}
