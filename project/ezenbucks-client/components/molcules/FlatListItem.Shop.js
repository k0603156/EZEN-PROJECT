import * as React from "react";
import styled from "styled-components";
import Colors from "../../constants/Colors";

import Text from "../atoms/Text";
import Image from "../atoms/Image";
import Col from "../atoms/Col";
import Row from "../atoms/Row";
import TouchableOpacity from "../atoms/TouchableOpacity";

export default function ShopItem({ item, onPress }) {
  return (
    <TouchableOpacity onPress={() => onPress(item)}>
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
          <Text title={item.shopName} size="md" style={{ color: "#fff" }} />
          <Text title={item.shopAddress} size="xs" style={{ color: "#fff" }} />
        </Col>
        <Col>
          <Text
            title={`${Number(item.distance).toFixed(1)}km`}
            size="xs"
            style={{ color: "#fff" }}
          />
        </Col>
      </Row>
    </TouchableOpacity>
  );
}
