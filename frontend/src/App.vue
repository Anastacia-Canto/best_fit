<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { ref } from 'vue'

const drawer = ref(null)
</script>

<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer">
      <v-list>
        <v-list-item 
          to="/"
          prepend-icon="mdi-home"
          title="Home"
        ></v-list-item>
        <v-list-item
          to="/login"
          prepend-icon="mdi-login"
          title="Login"
        ></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-app-bar-title>Application</v-app-bar-title>
    </v-app-bar>

    <v-main class="main">
      <Suspense>
        <RouterView />
      </Suspense>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    data: () => ({ drawer: null }),
  }
</script>


<style scoped>

.main {
  width: 80vw;
  display: flex;
  justify-content: center;
}

</style>
