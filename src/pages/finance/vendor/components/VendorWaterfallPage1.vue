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
            <a-button type="link" size="small">打印</a-button>
            <a-button type="link" size="small"  @click="openHandler.payment=true">结算</a-button>
            <a-button type="link" danger size="small">删除</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
    <Teleport to="body">
      <PaymentModal v-model:open="openHandler.payment" />
    </Teleport>
  </div>
</template>
<script lang="ts" setup>
import { VendorOrderWaterFallColumn, VendorOrderWaterFallColumnType } from '~@/utils/columns'
import { useAntRowSelection } from '~@/utils/tools'
import ColorfulTag from '~@/components/utils/ColorfulTag.vue';
import { ORDER_STATUS_ARRAY } from '~@/utils/constant';
import PaymentModal from './PaymentModal.vue';

const data = ref([
  {
    id: '1',
    key: '1',
    status: 1
  }
])
const openHandler = ref({
  payment: false
})
const rowSelectedKeys = ref([])
const rowSelection = useAntRowSelection<VendorOrderWaterFallColumnType>(rowSelectedKeys);
</script>
<style lang="less" scoped>

</style>