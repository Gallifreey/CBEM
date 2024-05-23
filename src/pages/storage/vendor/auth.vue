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
            <a-form-item name="name" label="仓库标识">
              <a-input v-model:value="formState.name" />
            </a-form-item>
          </a-form>
        </template>
        <template v-if="currentPage === 1">
          2
        </template>
      </div>
      <div class="footer">
        <a-space>
          <a-button v-if="currentPage>0" @click="currentPage--">上一步</a-button>
          <a-button type="primary" v-if="currentPage==1">提交</a-button>
          <a-button type="primary" v-if="currentPage<1" @click="currentPage++">下一步</a-button>
        </a-space>
      </div>
    </template>
  </page-container>
</template>
<script lang="ts" setup>
import type { Rule } from 'ant-design-vue/es/form';

const currentPage = ref(0);
const rules: Record<string, Rule[]> = {
  name: [
    {
      required: true,
      message: '请输入仓库名称'
    }
  ]
}
const formState = ref({
  name: ""
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