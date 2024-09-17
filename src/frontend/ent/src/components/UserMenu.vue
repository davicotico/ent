<template>
  <q-btn flat round dense icon="more_vert">
    <q-menu>
      <div class="row no-wrap q-pa-md">
        <div class="column">
          <div class="text-h6 q-mb-md">Settings</div>
          <q-toggle v-model="isDark" label="Dark mode" />
          <q-toggle v-model="bluetooth" label="Bluetooth" />
        </div>
        <q-separator vertical inset class="q-mx-lg" />
        <div class="column items-center">
          <q-avatar size="72px">
            <img src="https://cdn.quasar.dev/img/avatar4.jpg" />
          </q-avatar>
          <div class="text-subtitle1 q-mt-md q-mb-xs">John Doe</div>
          <q-btn color="primary" label="Logout" push size="sm" v-close-popup />
        </div>
      </div>
    </q-menu>
  </q-btn>
</template>
<script setup lang="ts">
import { ref } from 'vue';
import { useQuasar } from 'quasar';
import { watch } from 'vue';

const $q = useQuasar();
const isDark = ref(false);

watch(isDark, (newValue) => {
  $q.dark.set(newValue);
});

const bluetooth = ref(false);
</script>
