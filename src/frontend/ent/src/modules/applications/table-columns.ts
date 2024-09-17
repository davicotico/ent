import { ApplicationResponseModel } from 'src/models/application.model';
import { QTableColumn } from 'quasar';

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

export { columns };
