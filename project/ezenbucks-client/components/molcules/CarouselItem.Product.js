import * as React from "react";
import styled from "styled-components";
import Layout, { normalize } from "../../constants/Layout";
import Col from "../atoms/Col";
import { URL } from "../../config";

const Container = styled.View`
  display: flex;
  flex: 1;
  flex-direction: column;
`;
const ProductImage = styled.Image`
  width: ${Layout.window.width}px;
  height: ${Layout.window.height - 250}px;
`;
const ProductText = styled.Text`
  text-align: center;
  font-size: ${normalize(18)}px;
  font-family: bigshot-one;
`;
export default function ProductItem({
  item: { itemId, itemName, itemPrice, itemSpecies },
}) {
  return (
    <Container>
      <ProductImage
        resizeMode={"contain"}
        source={{
          uri: `${URL}/resources/${itemSpecies}/${itemName}.png`,
        }}
      />
      <Col>
        <ProductText>{itemName}</ProductText>
        <ProductText>{`${itemPrice} 원`}</ProductText>
      </Col>
    </Container>
  );
}
