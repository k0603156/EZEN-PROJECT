import * as WebBrowser from "expo-web-browser";
import * as React from "react";
import {
  Image,
  Platform,
  StyleSheet,
  Text,
  Button,
  TouchableOpacity,
  View,
} from "react-native";
import { ScrollView } from "react-native-gesture-handler";
import { MonoText } from "../components/StyledText";

export default function HomeScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <ScrollView
        style={styles.container}
        contentContainerStyle={styles.contentContainer}
      >
        <View>
          <Text>home</Text>
          <Button
            title="Go to list"
            onPress={() => navigation.navigate("list")}
          />
        </View>
      </ScrollView>
    </View>
  );
}

HomeScreen.navigationOptions = {
  header: "test",
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
  },
  contentContainer: {
    paddingTop: 30,
  },
});
