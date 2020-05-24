import * as React from "react";
import Image from "../atoms/Image";
import Container from "../atoms/Container";

export default function BannerItem({ item: { image } }) {
  return (
    <Container style={{ padding: 0 }}>
      <Image
        resizeMode={"cover"}
        source={{ uri: image }}
        style={{
          height: "100%",
          width: "100%",
          padding: 0,
          margin: 0,
        }}
      />
    </Container>
  );
}
