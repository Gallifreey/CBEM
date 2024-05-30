<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-form :model="formState"
      :label-col="{ span: 8 }"
    	:wrapper-col="{ span: 10 }"
      >
        <a-form-item name="name" label="商品名称"  :rules="[{ required: true, message: '请输入商品名称' }]">
          <a-input v-model:value="formState.name"/>
        </a-form-item>
        <a-form-item name="description" label="商品描述">
          <a-input v-model:value="formState.description"/>
        </a-form-item>
        <a-form-item name="brand" label="品牌" :rules="[{ required: true, message: '请选择品牌' }]">
          <a-select v-model:value="formState.brand"/>
        </a-form-item>
        <a-form-item name="price" label="商品价格" :rules="[{ required: true, message: '请输入商品价格' }]">
          <a-input-number v-model:value="formState.price"/>
        </a-form-item>
        <a-form-item  name="picture" label="商品图片">
          <a-upload />
        </a-form-item>
        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button type="primary">确定</a-button>
        </a-form-item>
      </a-form>
    </template>
  </PageContainer>
</template>
<script lang="ts" setup>
interface FormState{
  name: string,
  description: string,
  brand: string,
  price: number,
  picture: string
}
const formState = ref<FormState>({
  name: "",
  description: "",
  brand: "",
  price: 1.0,
  picture: ""
})
</script>
<style lang="less" scoped>

</style>