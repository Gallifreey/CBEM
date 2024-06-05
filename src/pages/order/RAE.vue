<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-form :model="formState">
        <a-row :gutter="[30, 0]">
           <a-col :span="8">
             <a-form-item name="price" label="总额">
               <a-input-number style="width: 100%" v-model:value="formState.price"/>
             </a-form-item>
           </a-col>
           <a-col :span="8">
             <a-form-item name="state" label="状态">
               <a-select v-model:value="formState.state" :options="options"/>
             </a-form-item>
           </a-col>
           <a-col :span="8">
            <a-form-item name="publishTime" label="创建时间">
               <a-range-picker v-model:value="formState.publishTime" />
             </a-form-item>
           </a-col>
         </a-row>
         <a-row>
          <a-col :span="8">
            <a-button type="primary" @click="queryData()">查询</a-button>
          </a-col>
         </a-row>
      </a-form>
    </template>
    <a-table :columns="SalerRAEColumn" :data-source="dataFrame" :row-selection="rowSelection">
      <template #bodyCell="{record, column}">
        <template v-if="column.dataIndex === 'state'">
          <ColorfulTag :number="record.state" :text="RAE_STATUS_ARRAY[record.state]" />
        </template>
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a-button type="link">审阅</a-button>
            <a-button type="link" danger>删除</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
  </PageContainer>
</template>
<script lang="ts" setup>
import { SalerRAEColumn, SalerReturnAndExchangeColumnType } from '~@/utils/columns'
import dayjs from 'dayjs';
import { useAntRowSelection, generateObjectByArray } from '~@/utils/tools';
import ColorfulTag from '~@/components/utils/ColorfulTag.vue';
import { RAE_STATUS_ARRAY } from '~@/utils/constant';
import { RangeValue } from '~@/types/form';
import { getRAEList, queryRAE } from '~@/api/saler/order';
import { getUID } from '~@/utils/storage';

const dataFrame = ref<SalerReturnAndExchangeColumnType[]>([
  {
    orderId: "1111",
    price: 20.0,
    user: "我",
    state: 0,
    key: 0,
    publishTime: dayjs("2015/01/01")
  }
])
interface FormState {
  price: number,
  state: number,
  publishTime: RangeValue
}
const formState = ref<FormState>({
  price: 0,
  state: 0,
  publishTime: [dayjs(), dayjs()]
})
const rowSelectedKeys = ref([])
const rowSelection = useAntRowSelection<SalerReturnAndExchangeColumnType>(rowSelectedKeys);
async function loadData(){
  const { data } = await getRAEList(getUID());
  if(data) dataFrame.value = data;
}
async function queryData(){
  const { data } = await queryRAE(formState.value);
  if(data) dataFrame.value = data;
}
onMounted(() => {
  loadData();
})
const options = generateObjectByArray(RAE_STATUS_ARRAY);
</script>
<style lang="less" scoped>

</style>