import * as React from "react";
import styled from "styled-components";
import { Ionicons, MaterialCommunityIcons } from "@expo/vector-icons";
import Colors from "../constants/Colors";

import Button from "../components/atoms/Button";
import Col from "../components/atoms/Col";
import Row from "../components/atoms/Row";
import Carousel from "../components/molcules/Carousel";
import CarouselItem from "../components/molcules/CarouselItem.Banner";
import Greeting from "../components/molcules/Greeting";
import withPreload from "../hoc/withPreload";

const Container = styled.View`
  background-color: ${Colors.bgColor};
  display: flex;
  flex: 1;
  flex-direction: column;
`;

function Home({ navigation, preloadData }) {
  const Banners = [
    { image: require("../assets/images/main_bn.png") },
    { image: require("../assets/images/main_bn.png") },
  ];
  return (
    <Container wrapper>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Col style={{ flex: 1, margin: 0 }}>
        <Carousel data={Banners} renderItem={CarouselItem} />
      </Col>
      <Row style={{ flex: 1, margin: 0 }}>
        <Button
          icon={<Ionicons name="md-cafe" size={48} color="white" />}
          title="DRINK"
          onPress={() => navigation.navigate("Menu")}
          textStyle={{ color: "white" }}
          style={{ flex: 1, justifyContent: "center" }}
        />
        <Button
          icon={<MaterialCommunityIcons name="food" size={48} color="white" />}
          title="FOOD"
          onPress={() => navigation.navigate("Menu")}
          textStyle={{ color: "white" }}
          style={{ flex: 1, justifyContent: "center" }}
        />
      </Row>
    </Container>
  );
}
export default withPreload({
  images: [require("../assets/images/main_bn.png")],
})(Home);
