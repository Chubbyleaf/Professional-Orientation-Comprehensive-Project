<template>
  <div class="tagList">
    <el-card color="#385F73" dark class="back">
      <el-table
        :data="tagList"
        style="width: 100%; margin-left: 2%; margin-right: 5%"
      >
        <el-table-column prop="name" label="标签">
          <template slot-scope="scope"
            ><el-link @click="toTag(scope.row)">{{ scope.row.name }}</el-link>
          </template></el-table-column
        >
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "TagList",
  props: {},
  data() {
    return {
      tagList: [
        {
          id: "1",
          name: "自然",
        },
        {
          id: "2",
          name: "汽车",
        },
        {
          id: "3",
          name: "白噪音",
        },
      ],
    };
  },
  methods: {
    toTag(row) {
      console.log(row);
      this.$router.push({
        path: "/tag",
        query: { tag_id: row.id, tag_name: row.name },
      });
      this.$router.go(0);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.back {
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 20px;
}
</style>
