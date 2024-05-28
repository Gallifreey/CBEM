<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div class="container">
      <a-table :columns="VendorOrderWaterFallColumn" :row-selection="rowSelection" :data-source="data" :scroll="{x: 1000}">
        <template #bodyCell="{record, column}">
          <template v-if="column.dataIndex === 'status'">
            <ColorfulTag :text="ORDER_STATUS_ARRAY[record.status]" />
          </template>
          <template v-if="column.dataIndex === 'action'">
            <a-space>
              <a-button type="link" size="small">审阅</a-button>
              <a-button type="link" size="small">结算</a-button>
              <a-button type="link" danger size="small">删除</a-button>
            </a-space>
          </template>
        </template>
      </a-table>
    </div>
  </template>
  <script lang="ts" setup>
  import { VendorOrderWaterFallColumn, VendorOrderWaterFallColumnType } from '~@/utils/columns'
  import { useAntRowSelection } from '~@/utils/tools'
  import ColorfulTag from '~@/components/utils/ColorfulTag.vue';
  import { ORDER_STATUS_ARRAY } from '~@/utils/constant';
   
  const data = ref([
    {
      id: '1',
      key: '1',
      status: 1
    }
  ])
  const rowSelectedKeys = ref<(String | Number)[]>([]);
  const rowSelection = useAntRowSelection<VendorOrderWaterFallColumnType>(rowSelectedKeys);
  </script>
  <style lang="less" scoped>
  
  </style>