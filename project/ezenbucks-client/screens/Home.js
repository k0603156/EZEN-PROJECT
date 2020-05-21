import * as React from "react";
import styled from "styled-components";
import { Ionicons, MaterialCommunityIcons } from "@expo/vector-icons";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import Greeting from "../components/Greeting";
import Button from "../components/Button";

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

export default function Home({ navigation }) {
  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Rows></Rows>
      <Rows>
        <Button
          icon={<Ionicons name="md-cafe" size={48} color="white" />}
          text="DRINK"
          onPress={() => navigation.navigate("Menu")}
          textStyle={{ color: "white" }}
        />
        <Button
          icon={<MaterialCommunityIcons name="food" size={48} color="white" />}
          text="FOOD"
          onPress={() => navigation.navigate("Menu")}
          textStyle={{ color: "white" }}
        />
      </Rows>
    </Container>
  );
}
