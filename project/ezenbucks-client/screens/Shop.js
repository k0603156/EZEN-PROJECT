import * as React from "react";
import Colors from "../constants/Colors";

import Container from "../components/atoms/Container";
import Greeting from "../components/molcules/Greeting";
import FlatList from "../components/molcules/FlatList";
import FlatListItem from "../components/molcules/FlatListItem.Shop";
import SearchBar from "../components/molcules/SearchBar";

export default function Shop({ navigation }) {
  const [input, setInput] = React.useState("");
  const [shops, setShops] = React.useState([
    { id: "0", title: "한국프레스센터", address: "서울시 중구..." },
    { id: "1", title: "무교동", address: "서울시 중구..." },
    { id: "2", title: "시청", address: "서울시 중구..." },
    { id: "3", title: "시청플러스", address: "서울시 중구..." },
    { id: "4", title: "소공동", address: "서울시 중구..." },
    { id: "5", title: "소공로북창", address: "서울시 중구..." },
    { id: "6", title: "을지로국제빌딩", address: "서울시 중구..." },
    { id: "7", title: "소공동", address: "서울시 중구..." },
  ]);
  React.useEffect(() => {
    if ("geolocation" in navigator) {
      // requestCurrentPosition();
    }
  }, []);
  const requestCurrentPosition = () => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        console.log("Latitude is :", position.coords.latitude);
        console.log("Longitude is :", position.coords.longitude);
      },
      (error) => {},
      { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 },
    );
  };
  return (
    <Container style={{ flex: 1, padding: 0, backgroundColor: Colors.bgColor }}>
      <Greeting message="주문하실 매장을 선택해주세요." />
      <SearchBar value={input} onChangeText={(text) => setInput(text)} />
      <FlatList
        data={shops.filter((shop) => shop.title.includes(input))}
        renderItem={({ item }) => (
          <FlatListItem item={item} navigation={navigation} />
        )}
        keyExtractor={(shop) => shop.id}
      />
    </Container>
  );
}
