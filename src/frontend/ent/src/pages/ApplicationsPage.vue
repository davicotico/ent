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
import { QTableColumn } from 'quasar';
import { ApplicationResponseModel } from 'src/models/application.model';
import ApplicationsService from 'src/services/Applications.service';
import { Ref, onMounted, ref } from 'vue';

const columns: QTableColumn[] = [
  {
    name: 'code',
    required: true,
    label: 'Code',
    align: 'left',
    field: (row: ApplicationResponseModel) => row.code,
    sortable: true,
  },
  {
    name: 'name',
    required: true,
    label: 'Name',
    align: 'left',
    field: (row: ApplicationResponseModel) => row.name,
    sortable: true,
  },
  {
    name: 'url',
    required: true,
    label: 'URL',
    align: 'left',
    field: (row: ApplicationResponseModel) => row.url,
    sortable: true,
  },
  {
    name: 'description',
    required: true,
    label: 'Description',
    align: 'left',
    field: (row: ApplicationResponseModel) => row.description,
    sortable: true,
  },
];

const items: Ref<ApplicationResponseModel[]> = ref([]);

onMounted(() => {
  ApplicationsService.getApplications()
    .then((result) => {
      items.value = result.data;
    })
    .catch(() => {
      alert('Error desconocido');
    });
});
</script>
