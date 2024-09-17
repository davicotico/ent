<template>
  <q-page padding>
    <q-table
      title="Applications"
      :rows="items"
      :columns="columns"
      row-key="name"
      :binary-state-sort="true"
    />
  </q-page>
</template>
<script setup lang="ts">
import { useQuasar } from 'quasar';
import { ApplicationResponseModel } from 'src/models/application.model';
import { Ref, onMounted, ref } from 'vue';
import { columns } from './table-columns';
import { ApplicationService } from 'src/services/Applications.service';

const $q = useQuasar();
const applicationService = ApplicationService.getInstance();
const items: Ref<ApplicationResponseModel[]> = ref([]);

class Applications {
  public getAll() {
    $q.loading.show();
    applicationService
      .getApplications()
      .then((result) => {
        items.value = result.data;
      })
      .catch(() => {
        $q.notify({ type: 'negative', message: 'Error', position: 'top' });
      })
      .finally(() => {
        $q.loading.hide();
      });
  }
}

const applications = new Applications();

onMounted(() => {
  applications.getAll();
});
</script>
