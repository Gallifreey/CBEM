<template>
  <div class="container">
    <a-table :row-selection="rowSelection" :columns="columns" :dataSource="data?.results" showHeader>
      <template #bodyCell="{record, column}">
        <template v-if="column.dataIndex === 'name'">
          {{`${record.title} ${record.first}-${record.last}`}}
        </template>
      </template>
    </a-table>
  </div>
</template>
<script lang="ts" setup>
import { TableColumnType, Table } from 'ant-design-vue';
import axios from 'axios';

type NameType = {
  first: string,
  last: string,
  title?: string
};
type TableType = {
  id: string,
  gender: 'female' | 'male';
  name: NameType;
  email: string;
}
const selectedRowKeys = ref<TableType['email'][]>([]);

const onSelectChange = (changableRowKeys: string[]) => {
  selectedRowKeys.value = changableRowKeys;
};
const rowSelection = computed(() => {
  return {
    selectedRowKeys: unref(selectedRowKeys),
    onChange: onSelectChange,
    hideDefaultSelections: true,
    selections: [
      Table.SELECTION_ALL,
      Table.SELECTION_INVERT,
      Table.SELECTION_NONE,
      {
        key: 'odd',
        text: '选中偶数行',
        onSelect: (changableRowKeys: Array<string>) => {
          let newSelectedRowKeys = [];
          newSelectedRowKeys = changableRowKeys.filter((_key: string, index: number) => {
            if (index % 2 !== 0) {
              return false;
            }
            return true;
          });
          selectedRowKeys.value = newSelectedRowKeys;
        },
      },
      {
        key: 'even',
        text: '选中奇数行',
        onSelect: changableRowKeys => {
          let newSelectedRowKeys = [];
          newSelectedRowKeys = changableRowKeys.filter((_key: string, index: number) => {
            if (index % 2 !== 0) {
              return true;
            }
            return false;
          });
          selectedRowKeys.value = newSelectedRowKeys;
        },
      },
    ],
  };
});
const columns: TableColumnType<TableType>[] = [
  {
    title: 'Name',
    dataIndex: 'name',
    filters: [
      {
        text: 'l',
        value: 'l',
      },
      {
        text: 'Jim',
        value: 'Jim',
      },
      {
        text: 'Submenu',
        value: 'Submenu',
        children: [
          {
            text: 'Green',
            value: 'Green',
          },
          {
            text: 'Black',
            value: 'Black',
          },
        ],
      },
    ],
    onFilter: (value: any, record: TableType) => {
      return record.name.first.indexOf(value) === 0;
    },
    sorter: true,
    width: '20%',
  },
  {
    title: 'Gender',
    dataIndex: 'gender',
    filters: [
      { text: 'Male', value: 'male' },
      { text: 'Female', value: 'female' },
    ],
    width: '20%',
  },
  {
    title: 'Email',
    dataIndex: 'email',
  },
];

type APIParams = {
  results: number;
  page?: number;
  sortField?: string;
  sortOrder?: number;
  [key: string]: any;
};
type APIResult = {
  results: TableType[];
};

const queryData = (params: APIParams) => {
  return axios.get<APIResult>('https://randomuser.me/api?noinfo', { params });
};
const data = ref<APIResult>();
queryData({
  results: 50
}).then((res) => {
  data.value = res.data
})
</script>
<style lang="scss" scoped>

</style>