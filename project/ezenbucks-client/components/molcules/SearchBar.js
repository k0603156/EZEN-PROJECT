import * as React from "react";
import TextInput from "../atoms/TextInput";
import Container from "../atoms/Container";

export default function SearchBar({ value, onChangeText }) {
  return (
    <Container>
      <TextInput
        placeholder={"검색"}
        value={value}
        onChangeText={onChangeText}
      />
    </Container>
  );
}
