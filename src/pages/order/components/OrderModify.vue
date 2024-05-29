<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-modal title="订单信息修改" width="85%" v-model:open="openE" :closable="false" :mask-closable="false" :onOk="onSubmit">
    <a-form :model="formState" :rules="rules">
      <a-descriptions bordered>
        <a-descriptions-item label="订单描述" :span="3">
          <TransparentInput v-model:value="formState.description" width="100%" />
        </a-descriptions-item>
        <a-descriptions-item label="接收方" :span="2">
          <a-form-item name="target">
            <TransparentInput v-model:value="formState.target" width="100%"/>
          </a-form-item>
        </a-descriptions-item>
        <a-descriptions-item label="发送方" :span="2">
          <a-form-item name="source">
            <TransparentInput v-model:value="formState.source" width="100%"/>
          </a-form-item>
        </a-descriptions-item>
        <a-descriptions-item label="物品清单" :span="5">
          <a-table :columns="VendorOrderBOMListColumn">
            
          </a-table>
        </a-descriptions-item>
        <a-descriptions-item label="备注" :span="5">
          <TransparentInput v-model:value="formState.memo" width="100%" type="textarea"/>
        </a-descriptions-item>
      </a-descriptions>
    </a-form>
  </a-modal>
</template>
<script lang="ts" setup>
import TransparentInput from '~@/components/utils/TransparentInput.vue';
import { VendorOrderBOMListColumn } from '~@/utils/columns';
import { objectValuesArrayFilter } from '~@/utils/tools';
import type { Rule } from 'ant-design-vue/es/form';
import { modifyOrderApi } from '~@/api/common/order';
import { message } from 'ant-design-vue';

const props = defineProps({
  data: {
    type: Object
  },
  open: {
    type: Boolean,
    default: false
  }
})
const emits = defineEmits(['update:open']);
const openE = useVModel(props, 'open', emits);
interface FormState {
  description: string,
  source: string,
  target: string,
  memo: string
}
const formState = ref<FormState>({
  description: "113",
  source: "1",
  target: "2",
  memo: "111"
})
const rules: Record<string, Rule[]> = {
  target: [
    {
      required: true,
      message: '请输入接收方'
    }
  ],
  source: [
    {
      required: true,
      message: '请输入发送方'
    }
  ]
}
objectValuesArrayFilter(VendorOrderBOMListColumn, ['id'], ['dataIndex'])
async function onSubmit(){
  const { code } = await modifyOrderApi(formState.value);
  if(code !== 0) openE.value = false;
  else {
    message.error("修改订单信息失败！")
  }
}
</script>
<style lang="less" scoped>

</style>
