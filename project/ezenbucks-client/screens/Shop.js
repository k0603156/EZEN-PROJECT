import * as React from "react";
import Colors from "../constants/Colors";

import Container from "../components/atoms/Container";
import Greeting from "../components/molcules/Greeting";
import FlatList from "../components/molcules/FlatList";
import FlatListItem from "../components/molcules/FlatListItem.Shop";
import SearchBar from "../components/molcules/SearchBar";
import withPreload from "../hoc/withPreload";
import { fetchListShop } from "../services/api";

function Shop({ navigation, route, preloadData }) {
  const [input, setInput] = React.useState("");
  const [shops, setShops] = React.useState([]);
  const requestCurrentPosition = () => {
    navigator.geolocation.getCurrentPosition(
      async (position) => {
        const { status, data } = await fetchListShop({
          longitude: position.coords.longitude,
          latitude: position.coords.latitude,
        });
        if (status === 200) {
          setShops(data);
        }
      },
      (error) => {},
      { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 }
    );
  };
  React.useEffect(() => {
    if ("geolocation" in navigator) {
      requestCurrentPosition();
    }
  }, []);
  const onItemPress = (shop) => {
    navigation.navigate("Order", { items: route.params.items, shop });
  };
  return (
    <Container style={{ flex: 1, padding: 0, backgroundColor: Colors.bgColor }}>
      <Greeting message="주문하실 매장을 선택해주세요." />
      <SearchBar value={input} onChangeText={(text) => setInput(text)} />
      <FlatList
        data={shops.filter((shop) => shop.shopName.includes(input))}
        renderItem={({ item }) => (
          <FlatListItem item={item} onPress={onItemPress} />
        )}
        keyExtractor={(shop) => shop.id}
      />
    </Container>
  );
}

export default withPreload({
  apis: [
    async () => {
      await navigator.geolocation.getCurrentPosition(
        async (position) => {
          const { status, data } = await fetchListShop({
            longitude: position.coords.longitude,
            latitude: position.coords.latitude,
          });
          if (status === 200) {
            return data;
          }
        },
        (error) => {},
        { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 }
      );
    },
  ],
})(Shop);
