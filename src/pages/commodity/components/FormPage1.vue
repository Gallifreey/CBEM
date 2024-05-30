<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-form :model="basicInfoE" :rules="rules"  :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }">
      <a-form-item name="name" label="商品名称">
        <a-input v-model:value="basicInfoE.name"/>
      </a-form-item>
      <a-form-item name="description" label="商品描述">
        <a-input v-model:value="basicInfoE.description"/>
      </a-form-item>
      <a-form-item name="salePrice" label="商品销售价">
        <a-input-number v-model:value="basicInfoE.salePrice"/>
      </a-form-item>
      <a-form-item name="distributionPrice" label="商品分发价">
        <a-input-number v-model:value="basicInfoE.distributionPrice"/>
      </a-form-item>
      <a-form-item name="brand" label="品牌">
        <a-select v-model:value="basicInfoE.brand" :options="brandData"/>
      </a-form-item>
      <a-form-item name="deliveyState" label="递送方式">
        <a-select v-model:value="basicInfoE.deliveyState" :options="deliveryStateData" />
      </a-form-item>
      <a-form-item name="unit" label="单位">
        <a-input v-model:value="basicInfoE.unit"/>
      </a-form-item>
      <a-form-item name="weight" label="重量">
        <a-input-number v-model:value="basicInfoE.weight"/>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts" setup>
import { CommodityBasicInfoData, CommodityHolderValue } from '@/types/form'
import type { Rule } from 'ant-design-vue/es/form';
import { getAllBrand, getAllDeliveryState } from '~@/api/common/utils';

const props = defineProps({
  basicInfo: {
    type: Object as PropType<CommodityBasicInfoData>,
    default: CommodityHolderValue.basicInfo
  }
})
const emits = defineEmits(['update:basicInfo'])
const basicInfoE = useVModel(props, 'basicInfo', emits)

const rules: Record<string, Rule[]> = {
  name: [
    {
      required: true,
      message: '请输入商品名称'
    }
  ],
  salePrice: [
    {
      required: true,
      message: '请输入商品销售价'
    }
  ],
  brand: [
    {
      required: true,
      message: '请选择品牌'
    }
  ],
  deliveyState: [
    {
      required: true,
      message: '请选择递送方式'
    }
  ]
}
const brandData = ref();
const deliveryStateData = ref();
async function getBrandData(){
  const { data } = await getAllBrand();
  if(data)  brandData.value = data;
}
async function getDeliveryStateData(){
  const { data } = await getAllDeliveryState();
  if(data)  deliveryStateData.value = data;
}
onMounted(() => {
  getBrandData();
  getDeliveryStateData();
})
</script>
<style lang="less" scoped>

</style>