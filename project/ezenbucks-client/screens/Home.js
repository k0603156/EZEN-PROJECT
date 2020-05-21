import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import Greeting from "../components/Greeting";
import OrderButton from "../components/OrderButton";

const Container = styled.View`
  background-color: ${Colors.bgColor};
  display: flex;
  flex: 1;
  flex-direction: column;
`;
const Rows = styled.View`
  display: flex;
  flex: 1;
  flex-direction: row;
`;

export default function Home() {
  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Rows></Rows>
      <Rows>
        <OrderButton
          lib="ion-icons"
          name="md-cafe"
          size={48}
          color="white"
          message="DRINK"
          to="Menu"
        />
        <OrderButton
          lib="material-community-icons"
          name="food"
          size={48}
          color="white"
          message="FOOD"
          to="Menu"
        />
      </Rows>
    </Container>
  );
}
