import * as React from "react";
import styled from "styled-components";
import { View, Text, SafeAreaView, FlatList } from "react-native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import SearchBar from "../components/SearchBar";

const Container = styled.View`
  background-color: ${Colors.bgColor};
  display: flex;
  flex: 1;
  flex-direction: column;
`;
function Item({ id, title }) {
  return (
    <View style={{ padding: 16 }}>
      <Text style={{ color: "#fff", textAlign: "right" }}>{title}</Text>
    </View>
  );
}
export default function Shop({ navigation }) {
  const [state, setState] = React.useState({
    shops: [
      { id: "0", title: "한국프레스센터" },
      { id: "1", title: "무교동" },
    ],
  });
  return (
    <Container>
      <SearchBar />
      <FlatList
        data={state.shops}
        renderItem={({ item }) => {
          return <Item id={item.id} title={item.title} />;
        }}
        keyExtractor={(shop) => shop.id}
      />
    </Container>
  );
}
