import * as React from "react";
import Colors from "../../constants/Colors";
import Text from "../atoms/Text";
import Container from "../atoms/Container";

export default function Greeting({ message }) {
  return (
    <Container style={{ backgroundColor: Colors.darkGray }}>
      <Text size="sm" textAlign="center" title={message} />
    </Container>
  );
}
