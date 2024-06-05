<!-- eslint-disable vue/multi-word-component-names -->
<template>
 <page-container>
    <template #content>
      <div class="panel">
        <a-steps :current="currentPage" :items="[
          {
            title: '填写授权仓库信息',
          },
          {
            title: '挂载品牌',
          }
        ]">
        </a-steps>
      </div>
      <div class="container">
        <template v-if="currentPage === 0">
          <a-form :model="formState" :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }" :rules="rules">
            <a-form-item name="sid" label="仓库标识">
              <a-select v-model:value="formState.sid" :options="storageData" />
            </a-form-item>
          </a-form>
        </template>
        <template v-if="currentPage === 1">
          <a-form :model="formState" :label-col="{ span: 8 }" :wrapper-col="{ span: 8 }" :rules="rules">
            <a-form-item name="bid" label="品牌标识">
              <a-select v-model:value="formState.bid" :options="brandData" />
            </a-form-item>
          </a-form>
        </template>
      </div>
      <div class="footer">
        <a-space>
          <a-button v-if="currentPage>0" @click="currentPage--">上一步</a-button>
          <a-button type="primary" v-if="currentPage==1" @click="authStorage()">提交</a-button>
          <a-button type="primary" v-if="currentPage<1" @click="currentPage++">下一步</a-button>
        </a-space>
      </div>
    </template>
  </page-container>
</template>
<script lang="ts" setup>
import { message } from 'ant-design-vue';
import type { Rule } from 'ant-design-vue/es/form';
import { authNewStorage } from '~@/api/common/storage';
import { getAllBrand, getAllStorage } from '~@/api/common/utils';

const currentPage = ref(0);
const rules: Record<string, Rule[]> = {
  sid: [
    {
      required: true,
      message: '请输入仓库标识'
    }
  ],
  bid: [
    {
      required: true,
      message: '请输入品牌标识'
    }
  ]
}
const formState = ref({
  sid: 0,
  bid: 0
})
const router = useRouter();
async function authStorage(){
  const { code } = await authNewStorage(formState.value);
  if(code === 0) message.error("授权失败")
  else{
    message.success("授权成功");
    router.push({
      path: 'storage/vendor/list'
    })
  }
}
const brandData = ref();
const storageData = ref();
async function getBrandData(){
  const { data } = await getAllBrand();
  if(data)  brandData.value = data;
}
async function getStorageData(){
  const { data } = await getAllStorage();
  if(data)  storageData.value = data;
}
onMounted(() => {
  getBrandData();
  getStorageData();
})
</script>
<style lang="less" scoped>
.panel{
  width: 50%;
  margin-left: 25%;
  margin-right: 25%;
}
.container{
  position: relative;
  margin-top: 50px;
}
.footer{
  bottom: 0;
}
</style>