import * as React from "react";
import styled from "styled-components";
import { View } from "react-native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

const Container = styled.View`
  height: 50px;
`;
const SearchInput = styled.TextInput`
  padding: 8px;
`;
export default function SearchBar() {
  return (
    <Container>
      <SearchInput placeholder={"검색"} placeholderTextColor="white" />
    </Container>
  );
}
