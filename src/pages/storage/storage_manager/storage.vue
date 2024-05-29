<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-form :model="formState">
        <a-row :gutter="[16, 16]">
          <a-col :span="8">
            <a-form-item name="name" label="商品名称">
              <a-input v-model:value="formState.name"></a-input>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="price" label="出厂价格">
              <a-input-number v-model:value="formState.price" style="width: 100%"></a-input-number>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="brand" label="商品品牌">
              <a-select v-model:value="formState.price"></a-select>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="[16, 16]">
          <a-col :span="8">
            <a-form-item name="remained" label="剩余库存">
              <a-input-number v-model:value="formState.remained" style="width: 100%"></a-input-number>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="publishTime" label="操作时间">
              <a-range-picker v-model:value="formState.publishTime" style="width: 100%"></a-range-picker>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-space>
            <a-button type="primary">添加商品</a-button>
            <a-button>库存打印</a-button>
          </a-space>
        </a-row>
      </a-form>
    </template>
    <a-table :columns="StorageManagerStorageColumn" :data-source="data">
      <template #bodyCell="{column}">
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a-button type="link">审阅</a-button>
            <a-button type="link">修改</a-button>
            <a-button type="link" danger>删除</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
  </PageContainer>
</template>
<script lang="ts" setup>
import dayjs from 'dayjs';
import { RangeValue } from '~@/types/form';
import { StorageManagerStorageColumn, StorageManagerStorageType } from '~@/utils/columns'

const data = ref<StorageManagerStorageType[]>([
  {
    key: 0,
    name: "2111",
    brand: "111",
    publishTime: dayjs(),
    price: 12.00,
    remained: 1200,
    picture: "",
    description: "1111111111111111"
  }
])
interface FormState {
  name: string,
  price:number,
  brand: string,
  remained: number,
  publishTime: RangeValue
}
const formState = ref<FormState>({
  name: "",
  price: 0,
  brand: "",
  remained: 0,
  publishTime: [dayjs(), dayjs()]
})
</script>
<style lang="less" scoped>

</style>