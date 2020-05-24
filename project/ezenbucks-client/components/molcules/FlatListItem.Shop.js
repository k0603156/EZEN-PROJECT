import * as React from "react";
import styled from "styled-components";
import Colors from "../../constants/Colors";

import Text from "../atoms/Text";
import Image from "../atoms/Image";
import Col from "../atoms/Col";
import Row from "../atoms/Row";
import TouchableOpacity from "../atoms/TouchableOpacity";

export default function ShopItem({ item, navigation }) {
  return (
    <TouchableOpacity onPress={() => navigation.navigate("Order")}>
      <Row
        style={{
          justifyContent: "space-between",
          padding: 16,
          height: 82,
        }}
      >
        <Image
          source={{
            uri: "https://reactnative.dev/img/tiny_logo.png",
          }}
          style={{ width: 50, height: 50 }}
        />

        <Col style={{ flex: 1 }}>
          <Text title={item.title} size="md" style={{ color: "#fff" }} />
          <Text title={item.address} size="xs" style={{ color: "#fff" }} />
        </Col>
        <Col>
          <Text title={"95m"} size="xs" style={{ color: "#fff" }} />
        </Col>
      </Row>
    </TouchableOpacity>
  );
}
