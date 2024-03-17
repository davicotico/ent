<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title> Quasar App </q-toolbar-title>

        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
      <q-list>
        <q-item-label header>ENT</q-item-label>
        <EssentialLink
          v-for="link in linksList"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import EssentialLink, {
  EssentialLinkProps,
} from 'components/EssentialLink.vue';

defineOptions({
  name: 'MainLayout',
});

const linksList: EssentialLinkProps[] = [
  {
    title: 'Home',
    caption: 'quasar.dev',
    icon: 'home',
    link: 'https://quasar.dev',
  },
  {
    title: 'Applications',
    caption: 'github.com/quasarframework',
    icon: 'view_module',
    link: 'https://github.com/quasarframework',
  },
  {
    title: 'Users',
    caption: 'chat.quasar.dev',
    icon: 'person',
    link: 'https://chat.quasar.dev',
  },
  {
    title: 'Roles',
    caption: 'forum.quasar.dev',
    icon: 'groups',
    link: 'https://forum.quasar.dev',
  },
  {
    title: 'Permissions',
    caption: '@quasarframework',
    icon: 'checklist',
    link: 'https://twitter.quasar.dev',
  },
];

const leftDrawerOpen = ref(false);

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value;
}
</script>
