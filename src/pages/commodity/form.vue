<!-- eslint-disable vue/multi-word-component-names -->
<template>
 <page-container>
    <template #content>
      <a-steps :current="currentPage" :items="[
      {
        title: '商品基本信息',
      },
      {
        title: 'BOM信息',
      },
      {
        title: 'SKU信息',
      },
      {
        title: '归档',
      }
    ]">
      </a-steps>
      <div class="container">
        <template v-if="currentPage === 0">
          <FormPage1Vue :basic-info="data.basicInfo"/>
        </template>
        <template v-if="currentPage === 1">
          <FormPage2Vue :bom="data.bom"/>
        </template>
        <template v-if="currentPage === 2">
          <FormPage3Vue :sku="data.sku"/>
        </template>
        <template v-if="currentPage === 3">
          <FormPage4Vue :sku="data.meta"/>
        </template>
      </div>
      <div class="footer">
        <a-space>
          <a-button v-if="currentPage>0" @click="currentPage--">上一步</a-button>
          <a-button type="primary" v-if="currentPage==3" @click="onSubmit">提交</a-button>
          <a-button type="primary" v-if="currentPage<3" @click="currentPage++">下一步</a-button>
        </a-space>
      </div>
    </template>
  </page-container>
</template>
<script lang="ts" setup>
import { addCommodity } from "~@/api/common/commodity";
import { CommodityData, CommodityHolderValue } from "~@/types/form";
import FormPage1Vue from "./components/FormPage1.vue";
import FormPage2Vue from "./components/FormPage2.vue";
import FormPage3Vue from "./components/FormPage3.vue";
import FormPage4Vue from "./components/FormPage4.vue";
import { message } from "ant-design-vue";

const currentPage = ref(0);
const data = ref<CommodityData>(CommodityHolderValue)
const router = useRouter();
async function onSubmit(){
  const { code } = await addCommodity(data.value);
  if(code === 0) message.error("添加失败")
  else {
    message.success("添加成功")
    router.push({
      path: '/commodity/list'
    })
  }
}
</script>
<style lang="less" scoped>
.container{
  position: relative;
  margin-top: 50px;
}
.footer{
  bottom: 0;
}
</style>